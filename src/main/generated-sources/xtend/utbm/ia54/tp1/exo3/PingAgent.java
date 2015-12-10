package utbm.ia54.tp1.exo3;

import io.sarl.core.AgentSpawned;
import io.sarl.core.AgentTask;
import io.sarl.core.Behaviors;
import io.sarl.core.DefaultContextInteractions;
import io.sarl.core.Initialize;
import io.sarl.core.Logging;
import io.sarl.core.Schedules;
import io.sarl.lang.annotation.FiredEvent;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.Behavior;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.EventListener;
import io.sarl.lang.core.EventSpace;
import io.sarl.lang.core.Percept;
import io.sarl.lang.core.Scope;
import io.sarl.lang.core.Space;
import io.sarl.lang.core.SpaceID;
import io.sarl.lang.util.SynchronizedSet;
import io.sarl.util.OpenEventSpace;
import io.sarl.util.OpenEventSpaceSpecification;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import utbm.ia54.tp1.exo3.Ping;
import utbm.ia54.tp1.exo3.Pong;

/**
 * @author Lucas
 */
@SuppressWarnings("all")
public class PingAgent extends Agent {
  protected OpenEventSpace space;
  
  @Percept
  public void _handle_Initialize_0(final Initialize occurrence) {
    AgentContext _defaultContext = this.getDefaultContext();
    Object _get = occurrence.parameters[0];
    OpenEventSpace _orCreateSpaceWithSpec = _defaultContext.<OpenEventSpace>getOrCreateSpaceWithSpec(
      OpenEventSpaceSpecification.class, 
      ((UUID) _get));
    this.space = _orCreateSpaceWithSpec;
    EventListener _asEventListener = this.asEventListener();
    this.space.register(_asEventListener);
    this.println("waiting for Pong Agent");
    final AgentTask taskVar = this.task("waiting_for_partner");
    final Procedure1<Agent> _function = new Procedure1<Agent>() {
      public void apply(final Agent it) {
        EventSpace _defaultSpace = PingAgent.this.getDefaultSpace();
        SynchronizedSet<UUID> _participants = _defaultSpace.getParticipants();
        int _size = _participants.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          PingAgent.this.println("Pong Agent detected.");
          PingAgent.this.println("sending Ping #0");
          Ping evt = new Ping(0);
          UUID _iD = it.getID();
          Address _address = PingAgent.this.space.getAddress(_iD);
          evt.setSource(_address);
          PingAgent.this.space.emit(evt);
          PingAgent.this.cancel(taskVar);
        }
      }
    };
    this.every(taskVar, 1000, _function);
  }
  
  @Percept
  public void _handle_Pong_1(final Pong occurrence) {
    this.println(("Pong received #" + Integer.valueOf(occurrence.index)));
    Ping evt = new Ping((occurrence.index + 1));
    UUID _iD = this.getID();
    Address _address = this.space.getAddress(_iD);
    evt.setSource(_address);
    this.println(("Ping sent #" + Integer.valueOf(evt.index)));
    this.space.emit(evt);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#debug(java.lang.Object)}.
   * 
   * @see io.sarl.core.Logging#debug(java.lang.Object)
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected void debug(final Object message) {
    getSkill(io.sarl.core.Logging.class).debug(message);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#error(java.lang.Object)}.
   * 
   * @see io.sarl.core.Logging#error(java.lang.Object)
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected void error(final Object message) {
    getSkill(io.sarl.core.Logging.class).error(message);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#error(java.lang.Object,java.lang.Throwable)}.
   * 
   * @see io.sarl.core.Logging#error(java.lang.Object,java.lang.Throwable)
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected void error(final Object message, final Throwable exception) {
    getSkill(io.sarl.core.Logging.class).error(message, exception);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#getLogLevel()}.
   * 
   * @see io.sarl.core.Logging#getLogLevel()
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected int getLogLevel() {
    return getSkill(io.sarl.core.Logging.class).getLogLevel();
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#info(java.lang.Object)}.
   * 
   * @see io.sarl.core.Logging#info(java.lang.Object)
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected void info(final Object message) {
    getSkill(io.sarl.core.Logging.class).info(message);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#isDebugLogEnabled()}.
   * 
   * @see io.sarl.core.Logging#isDebugLogEnabled()
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected boolean isDebugLogEnabled() {
    return getSkill(io.sarl.core.Logging.class).isDebugLogEnabled();
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#isErrorLogEnabled()}.
   * 
   * @see io.sarl.core.Logging#isErrorLogEnabled()
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected boolean isErrorLogEnabled() {
    return getSkill(io.sarl.core.Logging.class).isErrorLogEnabled();
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#isInfoLogEnabled()}.
   * 
   * @see io.sarl.core.Logging#isInfoLogEnabled()
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected boolean isInfoLogEnabled() {
    return getSkill(io.sarl.core.Logging.class).isInfoLogEnabled();
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#isWarningLogEnabled()}.
   * 
   * @see io.sarl.core.Logging#isWarningLogEnabled()
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected boolean isWarningLogEnabled() {
    return getSkill(io.sarl.core.Logging.class).isWarningLogEnabled();
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#println(java.lang.Object)}.
   * 
   * @see io.sarl.core.Logging#println(java.lang.Object)
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected void println(final Object message) {
    getSkill(io.sarl.core.Logging.class).println(message);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#setLogLevel(int)}.
   * 
   * @see io.sarl.core.Logging#setLogLevel(int)
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected void setLogLevel(final int level) {
    getSkill(io.sarl.core.Logging.class).setLogLevel(level);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#setLoggingName(java.lang.String)}.
   * 
   * @see io.sarl.core.Logging#setLoggingName(java.lang.String)
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected void setLoggingName(final String message) {
    getSkill(io.sarl.core.Logging.class).setLoggingName(message);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#warning(java.lang.Object)}.
   * 
   * @see io.sarl.core.Logging#warning(java.lang.Object)
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected void warning(final Object message) {
    getSkill(io.sarl.core.Logging.class).warning(message);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Logging#warning(java.lang.Object,java.lang.Throwable)}.
   * 
   * @see io.sarl.core.Logging#warning(java.lang.Object,java.lang.Throwable)
   */
  @Generated
  @ImportedCapacityFeature(Logging.class)
  protected void warning(final Object message, final Throwable exception) {
    getSkill(io.sarl.core.Logging.class).warning(message, exception);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected void emit(final Event e) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).emit(e);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event,io.sarl.lang.core.Scope<io.sarl.lang.core.Address>)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event,io.sarl.lang.core.Scope<io.sarl.lang.core.Address>)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected void emit(final Event e, final Scope<Address> scope) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).emit(e, scope);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#getDefaultAddress()}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#getDefaultAddress()
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected Address getDefaultAddress() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultAddress();
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#getDefaultContext()}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#getDefaultContext()
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected AgentContext getDefaultContext() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultContext();
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#getDefaultSpace()}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#getDefaultSpace()
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected EventSpace getDefaultSpace() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultSpace();
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultContext(io.sarl.lang.core.AgentContext)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultContext(io.sarl.lang.core.AgentContext)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultContext(final AgentContext context) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultContext(context);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultContext(java.util.UUID)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultContext(java.util.UUID)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultContext(final UUID contextID) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultContext(contextID);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.Space)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.Space)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultSpace(final Space space) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultSpace(space);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.SpaceID)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.SpaceID)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultSpace(final SpaceID space) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultSpace(space);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultSpace(java.util.UUID)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultSpace(java.util.UUID)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultSpace(final UUID space) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultSpace(space);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isInDefaultSpace(io.sarl.lang.core.Event)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isInDefaultSpace(io.sarl.lang.core.Event)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isInDefaultSpace(final Event event) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isInDefaultSpace(event);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#receive(java.util.UUID,io.sarl.lang.core.Event)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#receive(java.util.UUID,io.sarl.lang.core.Event)
   */
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected void receive(final UUID receiver, final Event e) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).receive(receiver, e);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#spawn(java.lang.Class<? extends io.sarl.lang.core.Agent>,java.lang.Object[])}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#spawn(java.lang.Class<? extends io.sarl.lang.core.Agent>,java.lang.Object[])
   */
  @FiredEvent(AgentSpawned.class)
  @Generated
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected UUID spawn(final Class<? extends Agent> aAgent, final Object... params) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).spawn(aAgent, params);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Schedules#cancel(io.sarl.core.AgentTask)}.
   * 
   * @see io.sarl.core.Schedules#cancel(io.sarl.core.AgentTask)
   */
  @Generated
  @ImportedCapacityFeature(Schedules.class)
  protected boolean cancel(final AgentTask task) {
    return getSkill(io.sarl.core.Schedules.class).cancel(task);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Schedules#cancel(io.sarl.core.AgentTask,boolean)}.
   * 
   * @see io.sarl.core.Schedules#cancel(io.sarl.core.AgentTask,boolean)
   */
  @Generated
  @ImportedCapacityFeature(Schedules.class)
  protected boolean cancel(final AgentTask task, final boolean mayInterruptIfRunning) {
    return getSkill(io.sarl.core.Schedules.class).cancel(task, mayInterruptIfRunning);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Schedules#every(long,(io.sarl.lang.core.Agent)=>void)}.
   * 
   * @see io.sarl.core.Schedules#every(long,(io.sarl.lang.core.Agent)=>void)
   */
  @Generated
  @ImportedCapacityFeature(Schedules.class)
  protected AgentTask every(final long period, final Procedure1<? super Agent> procedure) {
    return getSkill(io.sarl.core.Schedules.class).every(period, procedure);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Schedules#every(io.sarl.core.AgentTask,long,(io.sarl.lang.core.Agent)=>void)}.
   * 
   * @see io.sarl.core.Schedules#every(io.sarl.core.AgentTask,long,(io.sarl.lang.core.Agent)=>void)
   */
  @Generated
  @ImportedCapacityFeature(Schedules.class)
  protected AgentTask every(final AgentTask task, final long period, final Procedure1<? super Agent> procedure) {
    return getSkill(io.sarl.core.Schedules.class).every(task, period, procedure);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Schedules#in(long,(io.sarl.lang.core.Agent)=>void)}.
   * 
   * @see io.sarl.core.Schedules#in(long,(io.sarl.lang.core.Agent)=>void)
   */
  @Generated
  @ImportedCapacityFeature(Schedules.class)
  protected AgentTask in(final long delay, final Procedure1<? super Agent> procedure) {
    return getSkill(io.sarl.core.Schedules.class).in(delay, procedure);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Schedules#in(io.sarl.core.AgentTask,long,(io.sarl.lang.core.Agent)=>void)}.
   * 
   * @see io.sarl.core.Schedules#in(io.sarl.core.AgentTask,long,(io.sarl.lang.core.Agent)=>void)
   */
  @Generated
  @ImportedCapacityFeature(Schedules.class)
  protected AgentTask in(final AgentTask task, final long delay, final Procedure1<? super Agent> procedure) {
    return getSkill(io.sarl.core.Schedules.class).in(task, delay, procedure);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Schedules#task(java.lang.String)}.
   * 
   * @see io.sarl.core.Schedules#task(java.lang.String)
   */
  @Generated
  @ImportedCapacityFeature(Schedules.class)
  protected AgentTask task(final String name) {
    return getSkill(io.sarl.core.Schedules.class).task(name);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Behaviors#asEventListener()}.
   * 
   * @see io.sarl.core.Behaviors#asEventListener()
   */
  @Generated
  @ImportedCapacityFeature(Behaviors.class)
  protected EventListener asEventListener() {
    return getSkill(io.sarl.core.Behaviors.class).asEventListener();
  }
  
  /**
   * See the capacity {@link io.sarl.core.Behaviors#registerBehavior(io.sarl.lang.core.Behavior)}.
   * 
   * @see io.sarl.core.Behaviors#registerBehavior(io.sarl.lang.core.Behavior)
   */
  @Generated
  @ImportedCapacityFeature(Behaviors.class)
  protected Behavior registerBehavior(final Behavior attitude) {
    return getSkill(io.sarl.core.Behaviors.class).registerBehavior(attitude);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Behaviors#unregisterBehavior(io.sarl.lang.core.Behavior)}.
   * 
   * @see io.sarl.core.Behaviors#unregisterBehavior(io.sarl.lang.core.Behavior)
   */
  @Generated
  @ImportedCapacityFeature(Behaviors.class)
  protected Behavior unregisterBehavior(final Behavior attitude) {
    return getSkill(io.sarl.core.Behaviors.class).unregisterBehavior(attitude);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Behaviors#wake(io.sarl.lang.core.Event)}.
   * 
   * @see io.sarl.core.Behaviors#wake(io.sarl.lang.core.Event)
   */
  @Generated
  @ImportedCapacityFeature(Behaviors.class)
  protected void wake(final Event evt) {
    getSkill(io.sarl.core.Behaviors.class).wake(evt);
  }
  
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   */
  @Generated
  public PingAgent(final UUID parentID) {
    super(parentID, null);
  }
  
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
   */
  @Generated
  public PingAgent(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
}
